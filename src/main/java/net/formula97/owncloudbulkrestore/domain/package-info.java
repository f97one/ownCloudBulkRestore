@XmlSchema(xmlns = {
        @XmlNs(prefix = "d", namespaceURI = "DAV:"),
        @XmlNs(prefix = "oc", namespaceURI = "http://owncloud.org/ns")
}, elementFormDefault = XmlNsForm.QUALIFIED)
package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;