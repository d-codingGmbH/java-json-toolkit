/*
 * Copyright (C) 2022 d-coding GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.dcoding;

import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Package;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Prints basic manifest data to console or as dialog if executed as application
 * 
 * @since  1.0
 */
public class Application {
  private static final String ATTRIBUTE_TITLE      = "Implementation-Title";
  private static final String ATTRIBUTE_VERSION    = "Implementation-Version";
  private static final String ATTRIBUTE_BUILD_DATE = "Build-Date";
  private static final String ATTRIBUTE_COPYRIGHT  = "Copyright";
  private static final String PARAMETER_FONT_NAME  = "OptionPane.messageFont";

  private static Map<String, String> metaAttributes = new HashMap<>();

  public static void main( String[] args ) {
    loadMetaAttributes();
    String text = buildInformationString();

    if (isConsoleApplication()) {
      displayInformationOnConsole(text);
    } else if (isGraphicalApplication()) {
      String dialogTitle = metaAttributes.get(ATTRIBUTE_TITLE);
      displayInformationAsDialog(dialogTitle, text);
    }
  }

  private static void loadMetaAttributes() {
    loadAttributesFromPackage();
    loadAttributesFromManifest();
  }

  private static void loadAttributesFromPackage() {
    Package pkg = Application.class.getPackage();
    metaAttributes.put(ATTRIBUTE_TITLE, pkg.getImplementationTitle());
    metaAttributes.put(ATTRIBUTE_VERSION, pkg.getImplementationVersion());
  }

  private static void loadAttributesFromManifest() {
    Manifest manifest = loadManifestOfLibrary();
    if (manifest != null) {
      Attributes attributes = manifest.getMainAttributes();
      metaAttributes.put(ATTRIBUTE_BUILD_DATE, attributes.getValue(ATTRIBUTE_BUILD_DATE));
      metaAttributes.put(ATTRIBUTE_COPYRIGHT, attributes.getValue(ATTRIBUTE_COPYRIGHT));
    }
  }

  private static Manifest loadManifestOfLibrary() {
    Manifest manifest = null;

    try {
      Enumeration<URL> resources = Application.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
      while (resources.hasMoreElements()) {
        URL url = resources.nextElement();
        InputStream stream = url.openStream();
        Manifest currentManifest = new Manifest(stream);
            
        if (isManifestOfLibrary(currentManifest)) {
          manifest = currentManifest;
          break;
          }
      }
    } catch (IOException ex) {
    }
    
    return manifest;
  }

  private static boolean isManifestOfLibrary(Manifest manifest) {
    Attributes attributes = manifest.getMainAttributes();
    return (isManifestTitleEqualToPackage(attributes) && isManifestVersionEqualToPackage(attributes));
  }

  private static boolean isManifestTitleEqualToPackage(Attributes manifestAttributes) {
    String packageTitle = metaAttributes.get(ATTRIBUTE_TITLE);
    String manifestTitle = manifestAttributes.getValue(ATTRIBUTE_TITLE);
    return ((manifestTitle != null) && manifestTitle.equals(packageTitle));
  }

  private static boolean isManifestVersionEqualToPackage(Attributes manifestAttributes) {
    String packageTitle = metaAttributes.get(ATTRIBUTE_VERSION);
    String manifestTitle = manifestAttributes.getValue(ATTRIBUTE_VERSION);
    return ((manifestTitle != null) && manifestTitle.equals(packageTitle));
  }

  private static String buildInformationString() {
    StringBuilder builder = new StringBuilder();
    
    addTitleAndVersionInformation(builder);
    addBuildInformationIfPresent(builder);
    addCopyrightInformationIfPresent(builder);

    return builder.toString();
  }

  private static void addTitleAndVersionInformation(StringBuilder builder) {
    String title = metaAttributes.get(ATTRIBUTE_TITLE);
    String version = metaAttributes.get(ATTRIBUTE_VERSION);
    builder.append(String.format("%s v%s", title, version));
  }

  private static void addBuildInformationIfPresent(StringBuilder builder) {
    String text = getLocalDateTimeString();
    if (text != null) {
      builder.append(String.format("\n  Built:     %s", text));
    }
  }

  private static void addCopyrightInformationIfPresent(StringBuilder builder) {
    String text = metaAttributes.get(ATTRIBUTE_COPYRIGHT);
    if (text != null) {
      builder.append(String.format("\n  Copyright: %s", text));
    }
  }

  private static String getLocalDateTimeString() {
    String utcBuildDateTime = metaAttributes.get(ATTRIBUTE_BUILD_DATE);
    String localBuildDateTime = convertUtcToLocalDateTimeString(utcBuildDateTime);
    return localBuildDateTime;
  }

  private static String convertUtcToLocalDateTimeString(String utcDateTime) {
    String localDateTime = null;

    if (utcDateTime != null) {
      ZoneId localZoneId = ZoneId.systemDefault();
      DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(localZoneId);
      try {
        ZonedDateTime zonedUtcDateTime = ZonedDateTime.parse(utcDateTime, DateTimeFormatter.ISO_DATE_TIME);
        Instant instant = zonedUtcDateTime.toInstant();
        localDateTime = formatter.format(instant);
      } catch (DateTimeParseException ex) {
      }
    }

    return localDateTime;
  }

  private static boolean isConsoleApplication() {
    return (System.console() != null);
  }

  private static void displayInformationOnConsole(String message) {
    System.console().writer().println(message);
  }

  private static boolean isGraphicalApplication() {
    return (!GraphicsEnvironment.isHeadless());
  }

  private static void displayInformationAsDialog(String title, String message) {
    try {
      String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
      UIManager.setLookAndFeel(lookAndFeel);

      Font defaultFont = (Font)UIManager.get(PARAMETER_FONT_NAME);
      Font monospaceFont = new Font(Font.MONOSPACED, Font.PLAIN, defaultFont.getSize());
      UIManager.put(PARAMETER_FONT_NAME, monospaceFont);
    } catch (Exception ex) {
    }

    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }
}
