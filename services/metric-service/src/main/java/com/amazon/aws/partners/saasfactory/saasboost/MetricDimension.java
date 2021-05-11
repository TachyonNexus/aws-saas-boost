/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazon.aws.partners.saasfactory.saasboost;

import java.util.Objects;

public class MetricDimension {
    private String nameSpace;
    private String metricName;

    //note that tenantId is used during processing and not passed
    private String tenantId;

    public MetricDimension(String nameSpace, String metricName, String tenantId) {
        this.nameSpace = nameSpace;
        this.metricName = metricName;
        this.tenantId = tenantId;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetricDimension that = (MetricDimension) o;
        return nameSpace.equals(that.nameSpace) &&
                metricName.equals(that.metricName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSpace, metricName);
    }

    @Override
    public String toString() {
        return "MetricDimension{" +
                "nameSpace='" + nameSpace + '\'' +
                ", metricName='" + metricName + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
