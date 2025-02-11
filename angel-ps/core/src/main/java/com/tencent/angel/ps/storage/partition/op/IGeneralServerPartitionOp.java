/*
 * Tencent is pleased to support the open source community by making Angel available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.tencent.angel.ps.storage.partition.op;

import com.tencent.angel.common.Serialize;
import com.tencent.angel.common.StreamSerialize;
import com.tencent.angel.ml.matrix.psf.update.base.PartitionUpdateParam;
import com.tencent.angel.ml.matrix.psf.update.base.UpdateFunc;
import com.tencent.angel.ps.server.data.request.UpdateOp;
import com.tencent.angel.psagent.matrix.transport.router.KeyValuePart;
import io.netty.buffer.ByteBuf;

/**
 * Basic operation for partition storage
 */
public interface IGeneralServerPartitionOp extends Serialize, StreamSerialize {

  /**
   * Init the storage
   */
  void init();

  /**
   * Reset the storage
   */
  void reset();

  /**
   * Update the partition use PSF
   *
   * @param func update PSF
   * @param partParam update PSF param
   */
  void update(UpdateFunc func, PartitionUpdateParam partParam);

  /**
   * Update the partition use pipeline mode
   *
   * @param buf input buf
   * @param op update method
   */
  void update(ByteBuf buf, UpdateOp op);

  /**
   * Get total element number in partition
   * @return total element in partition
   */
  long getElemNum();
}
