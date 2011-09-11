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
package org.jclouds.cloudstack.options;

import org.jclouds.cloudstack.domain.TemplateFilter;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what templates information is returned
 * 
 * @see <a href="http://download.cloud.com/releases/2.2.0/api/user/listTemplates.html" />
 * @author Adrian Cole
 */
public class ListTemplatesOptions extends AccountInDomainOptions {
   public ListTemplatesOptions() {
      filter(TemplateFilter.EXECUTABLE);
   }

   public static final ListTemplatesOptions NONE = new ListTemplatesOptions();

   /**
    * @param filter
    *           how to constrain the list
    */
   public ListTemplatesOptions filter(TemplateFilter filter) {
      this.queryParameters.replaceValues("templatefilter", ImmutableSet.of(filter.toString()));
      return this;
   }

   /**
    * @param id
    *           the template ID
    */
   public ListTemplatesOptions id(long id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
      return this;
   }

   /**
    * @param name
    *           the template name
    */
   public ListTemplatesOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }

   /**
    * @param zoneId
    *           list templates by zoneId.
    */
   public ListTemplatesOptions zoneId(long zoneId) {
      this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId + ""));
      return this;

   }

   /**
    * @param hypervisor
    *           the hypervisor for which to restrict the search
    */
   public ListTemplatesOptions hypervisor(String hypervisor) {
      this.queryParameters.replaceValues("hypervisor", ImmutableSet.of(hypervisor));
      return this;
   }

   public static class Builder {

      /**
       * @see ListTemplatesOptions#filter
       */
      public static ListTemplatesOptions filter(TemplateFilter filter) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.filter(filter);
      }

      /**
       * @see ListTemplatesOptions#domainId
       */
      public static ListTemplatesOptions domainId(long id) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.domainId(id);
      }

      /**
       * @see ListTemplatesOptions#accountInDomain
       */
      public static ListTemplatesOptions accountInDomain(String account, long domain) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.accountInDomain(account, domain);
      }

      /**
       * @see ListTemplatesOptions#id
       */
      public static ListTemplatesOptions id(long id) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.id(id);
      }

      /**
       * @see ListTemplatesOptions#name
       */
      public static ListTemplatesOptions name(String name) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.name(name);
      }

      /**
       * @see ListTemplatesOptions#zoneId
       */
      public static ListTemplatesOptions zoneId(long id) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.zoneId(id);
      }

      /**
       * @see ListTemplatesOptions#hypervisor
       */
      public static ListTemplatesOptions hypervisor(String hypervisor) {
         ListTemplatesOptions options = new ListTemplatesOptions();
         return options.hypervisor(hypervisor);
      }
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListTemplatesOptions accountInDomain(String account, long domain) {
      return ListTemplatesOptions.class.cast(super.accountInDomain(account, domain));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListTemplatesOptions domainId(long domainId) {
      return ListTemplatesOptions.class.cast(super.domainId(domainId));
   }
}
