/*
 * Copyright 1999-2021 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.chaosblade.box.common.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.chaosblade.box.common.constants.ChaosConstant;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yefei
 */
public class InetUtils {

    public static String getLocalHost() {
        String hostAddress = SystemPropertiesUtils.getEnvOrPropertiesValue(ChaosConstant.CHAOS_ADDRESS_KEY);
        if (StrUtil.isBlank(hostAddress)) {
            try {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                AnyThrow.throwUnchecked(e);
            } //获取到本机的hostAddress
            return hostAddress;
        }
        return hostAddress;
    }

}
