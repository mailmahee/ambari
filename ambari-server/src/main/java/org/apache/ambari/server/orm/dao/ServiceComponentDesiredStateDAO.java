/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.server.orm.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import org.apache.ambari.server.orm.entities.ServiceComponentDesiredStateEntityPK;
import org.apache.ambari.server.orm.entities.ServiceComponentDesiredStateEntity;

import javax.persistence.EntityManager;

public class ServiceComponentDesiredStateDAO {
  @Inject
  Provider<EntityManager> entityManagerProvider;

  @Transactional
  public ServiceComponentDesiredStateEntity findByPK(ServiceComponentDesiredStateEntityPK primaryKey) {
    return entityManagerProvider.get().find(ServiceComponentDesiredStateEntity.class, primaryKey);
  }

  @Transactional
  public void refresh(ServiceComponentDesiredStateEntity serviceComponentDesiredStateEntity) {
    entityManagerProvider.get().refresh(serviceComponentDesiredStateEntity);
  }

  @Transactional
  public void create(ServiceComponentDesiredStateEntity serviceComponentDesiredStateEntity) {
    entityManagerProvider.get().persist(serviceComponentDesiredStateEntity);
  }

  @Transactional
  public ServiceComponentDesiredStateEntity merge(ServiceComponentDesiredStateEntity serviceComponentDesiredStateEntity) {
    return entityManagerProvider.get().merge(serviceComponentDesiredStateEntity);
  }

  @Transactional
  public void remove(ServiceComponentDesiredStateEntity serviceComponentDesiredStateEntity) {
    entityManagerProvider.get().remove(merge(serviceComponentDesiredStateEntity));
  }

  @Transactional
  public void removeByPK(ServiceComponentDesiredStateEntityPK primaryKey) {
    remove(findByPK(primaryKey));
  }

}
