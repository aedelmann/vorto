/*******************************************************************************
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

package org.eclipse.vorto.remoterepository.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.vorto.remoterepository.internal.converter.parser.xml.InformationModelXmiModelParser;
import org.eclipse.vorto.remoterepository.model.ModelContent;
import org.eclipse.vorto.remoterepository.model.ModelType;
import org.eclipse.vorto.remoterepository.model.ModelView;
import org.junit.Test;

public class InformationModelXmiModelParserTest {
	InformationModelXmiModelParser service = new InformationModelXmiModelParser();

	@Test
	public void getInfoModelFromXmi() throws IOException {
		Path modelPath = Paths
				.get("src/test/resources/modelexamples/org.eclipse.vorto/SomeInfoModel/1.0.0/SomeInfoModel.infomodel_xmi");
		byte[] modelArray = Files.readAllBytes(modelPath);

		ModelContent modelContent = new ModelContent(
				ModelType.INFORMATIONMODEL, modelArray);
		ModelView modelView = service.parse(modelContent);
		assertEquals("org.eclipse.vorto", modelView.getModelId().getNamespace());
		assertEquals("SomeInfoModel", modelView.getModelId().getName());
		assertEquals("1.0.0", modelView.getModelId().getVersion());
		assertEquals(ModelType.INFORMATIONMODEL, modelView.getModelId()
				.getModelType());
		assertEquals("Information model for SomeInfoModel",
				modelView.getDescription());
		assertTrue(modelView.getReferenceModels().size() == 2);
		assertEquals(modelView.getReferenceModels().get(0).getNamespace(),
				"org.eclipse.vorto.ColorLight");
	}
}
