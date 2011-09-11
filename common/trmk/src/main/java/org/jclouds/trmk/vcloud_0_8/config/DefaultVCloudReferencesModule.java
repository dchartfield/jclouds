/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.trmk.vcloud_0_8.config;

import static org.jclouds.Constants.PROPERTY_IDENTITY;

import java.net.URI;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.jclouds.trmk.vcloud_0_8.domain.Catalog;
import org.jclouds.trmk.vcloud_0_8.domain.ReferenceType;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;

/**
 * 
 * @author Adrian Cole
 */
public class DefaultVCloudReferencesModule extends AbstractModule {

   @Override
   protected void configure() {

   }

   @Provides
   @org.jclouds.trmk.vcloud_0_8.endpoints.Org
   @Singleton
   protected ReferenceType provideDefaultOrg(DefaultOrgForUser defaultOrgURIForUser,
         @Named(PROPERTY_IDENTITY) String user) {
      return defaultOrgURIForUser.apply(user);
   }

   @Provides
   @Singleton
   @org.jclouds.trmk.vcloud_0_8.endpoints.Org
   protected Predicate<ReferenceType> provideDefaultOrgSelector(Injector i) {
      return Predicates.alwaysTrue();
   }

   @Provides
   @org.jclouds.trmk.vcloud_0_8.endpoints.TasksList
   @Singleton
   protected ReferenceType provideDefaultTasksList(DefaultTasksListForOrg defaultTasksListURIForOrg,
         @org.jclouds.trmk.vcloud_0_8.endpoints.Org ReferenceType defaultOrg) {
      return defaultTasksListURIForOrg.apply(defaultOrg);
   }

   @Provides
   @Singleton
   @org.jclouds.trmk.vcloud_0_8.endpoints.TasksList
   protected Predicate<ReferenceType> provideDefaultTasksListSelector(Injector i) {
      return Predicates.alwaysTrue();
   }

   @Provides
   @org.jclouds.trmk.vcloud_0_8.endpoints.Catalog
   @Singleton
   protected ReferenceType provideDefaultCatalog(DefaultCatalogForOrg defaultCatalogURIForOrg,
         @org.jclouds.trmk.vcloud_0_8.endpoints.Org ReferenceType defaultOrg) {
      return defaultCatalogURIForOrg.apply(defaultOrg);
   }

   @Provides
   @Singleton
   @org.jclouds.trmk.vcloud_0_8.endpoints.Catalog
   protected Predicate<ReferenceType> provideDefaultCatalogSelector(Injector i) {
      return Predicates.alwaysTrue();
   }

   @Provides
   @Singleton
   protected Supplier<Map<URI, ? extends org.jclouds.trmk.vcloud_0_8.domain.Catalog>> provideCatalogsById(
         Supplier<Map<String, Map<String, ? extends org.jclouds.trmk.vcloud_0_8.domain.Catalog>>> supplier) {
      return Suppliers
            .compose(
                  new Function<Map<String, Map<String, ? extends org.jclouds.trmk.vcloud_0_8.domain.Catalog>>, Map<URI, ? extends org.jclouds.trmk.vcloud_0_8.domain.Catalog>>() {

                     @Override
                     public Map<URI, ? extends Catalog> apply(Map<String, Map<String, ? extends Catalog>> arg0) {
                        Builder<URI, Catalog> builder = ImmutableMap.<URI, Catalog> builder();
                        for (Map<String, ? extends Catalog> v1 : arg0.values()) {
                           for (Catalog v2 : v1.values()) {
                              builder.put(v2.getHref(), v2);
                           }
                        }
                        return builder.build();
                     }

                  }, supplier);
   }

   @Provides
   @org.jclouds.trmk.vcloud_0_8.endpoints.VDC
   @Singleton
   protected ReferenceType provideDefaultVDC(DefaultVDCForOrg defaultVDCURIForOrg,
         @org.jclouds.trmk.vcloud_0_8.endpoints.Org ReferenceType defaultOrg) {
      return defaultVDCURIForOrg.apply(defaultOrg);
   }

   @Provides
   @Singleton
   @org.jclouds.trmk.vcloud_0_8.endpoints.VDC
   protected Predicate<ReferenceType> provideDefaultVDCSelector(Injector i) {
      return Predicates.alwaysTrue();
   }

   @Provides
   @org.jclouds.trmk.vcloud_0_8.endpoints.Network
   @Singleton
   protected ReferenceType provideDefaultNetwork(DefaultNetworkForVDC defaultNetworkURIForVDC,
         @org.jclouds.trmk.vcloud_0_8.endpoints.VDC ReferenceType defaultVDC) {
      return defaultNetworkURIForVDC.apply(defaultVDC);
   }

   @Provides
   @Singleton
   @org.jclouds.trmk.vcloud_0_8.endpoints.Network
   protected Predicate<ReferenceType> provideDefaultNetworkSelector(Injector i) {
      return Predicates.alwaysTrue();
   }
}
