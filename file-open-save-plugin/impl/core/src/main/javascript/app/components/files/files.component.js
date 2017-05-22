/*!
 * PENTAHO CORPORATION PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2017 Pentaho Corporation (Pentaho). All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Pentaho and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Pentaho and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Pentaho is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Pentaho,
 * explicitly covering such access.
 */
/**
 * The File Open and Save Files component.
 *
 * This provides the component for the Files list on search or files view.
 **/
define([
  "text!./files.html",
  "css!./files.css"
], function(filesTemplate) {
  "use strict";

  var options = {
    bindings: {
    },
    template: filesTemplate,
    controllerAs: "vm",
    controller: filesController
  };

  function filesController() {
    var vm = this;
    vm.$onInit = onInit;

    function onInit() {
      vm.nameHeader = "Name";
      vm.typeHeader = "Type";
      vm.lastSaveHeader = "Last saved";
    }
  }

  return {
    name: "files",
    options: options
  };
});
