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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "fileSystemType",
//        "mountPoint",
//        "fsx",
//        "efs"
//})

@JsonDeserialize(builder = SharedFilesystem.Builder.class)
public class SharedFilesystem {

    private SharedFilesystem(SharedFilesystem.Builder builder) {
        this.mountPoint = builder.mountPoint;
        this.fsx = builder.fsx;
        this.efs = builder.efs;
        this.fileSystemType = builder.fileSystemType;
    }

    public static SharedFilesystem.Builder builder() {
        return new SharedFilesystem.Builder();
    }

    private String fileSystemType;
    private String mountPoint;
    private FsxFilesystem fsx;

    private EfsFilesystem efs;

    public String getFileSystemType() {
        return fileSystemType;
    }

    public String getMountPoint() {
        return mountPoint;
    }

    public FsxFilesystem getFsx() {
        return fsx;
    }

    public EfsFilesystem getEfs() {
        return efs;
    }


    @JsonPOJOBuilder(withPrefix = "") // setters aren't named with[Property]
    public static final class Builder {
        private FsxFilesystem fsx;
        private EfsFilesystem efs;
        private String mountPoint;
        private String fileSystemType;

        private Builder() {
        }

        public Builder mountPoint(String mountPoint) {
            this.mountPoint = mountPoint;
            return this;
        }

        public Builder fsx(FsxFilesystem fsx) {
            this.fsx = fsx;
            return this;
        }

        public Builder efs(EfsFilesystem efs) {
            this.efs = efs;
            return this;
        }

        public Builder fileSystemType(String fileSystemType) {
            this.fileSystemType = fileSystemType;
            return this;
        }

        public SharedFilesystem build() {
            return new SharedFilesystem(this);
        }
    }
}