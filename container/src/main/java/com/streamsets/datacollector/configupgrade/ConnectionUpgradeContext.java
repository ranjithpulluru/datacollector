/*
 * Copyright 2020 StreamSets Inc.
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
package com.streamsets.datacollector.configupgrade;

import com.streamsets.pipeline.api.Config;
import com.streamsets.pipeline.api.StageUpgrader;

import java.util.List;

public class ConnectionUpgradeContext implements StageUpgrader.Context {

  private final String library;
  private final String type;
  private final String connectionId;
  private final int fromVersion;
  private final int toVersion;

  public ConnectionUpgradeContext(String library, String type, String connectionId, int fromVersion, int toVersion) {
    this.library = library;
    this.type = type;
    this.connectionId = connectionId;
    this.fromVersion = fromVersion;
    this.toVersion = toVersion;
  }

  @Override
  public String getLibrary() {
    return library;
  }

  @Override
  public String getStageName() {
    return "Connection " + type;
  }

  @Override
  public String getStageInstance() {
    return getStageName() + connectionId;
  }

  @Override
  public int getFromVersion() {
    return fromVersion;
  }

  @Override
  public int getToVersion() {
    return toVersion;
  }

  @Override
  public void registerService(Class service, List<Config> configs) {
    // noop
  }
}
