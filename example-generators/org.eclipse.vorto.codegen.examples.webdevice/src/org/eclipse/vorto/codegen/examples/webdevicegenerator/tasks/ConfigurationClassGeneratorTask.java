/*******************************************************************************
 *  Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v1.0 which accompany this distribution.
 *   
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  The Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *   
 *  Contributors:
 *  Bosch Software Innovations GmbH - Please refer to git log
 *******************************************************************************/
package org.eclipse.vorto.codegen.examples.webdevicegenerator.tasks;

import org.eclipse.vorto.codegen.api.tasks.AbstractTemplateGeneratorTask;
import org.eclipse.vorto.codegen.api.tasks.ITemplate;
import org.eclipse.vorto.codegen.examples.webdevicegenerator.tasks.templates.ConfigurationClassTemplate;
import org.eclipse.vorto.core.api.model.functionblock.FunctionblockModel;

public class ConfigurationClassGeneratorTask extends
		AbstractTemplateGeneratorTask<FunctionblockModel> {

	@Override
	public String getFileName(final FunctionblockModel model) {
		return model.getName() + "Configuration.java";
	}

	@Override
	public String getPath(final FunctionblockModel model) {
		return ModuleUtil.getModelPath(model);
	}

	@Override
	public ITemplate<FunctionblockModel> getTemplate() {
		return new ConfigurationClassTemplate();
	}
}
