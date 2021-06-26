package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@XmlRootElement(name = "prop", namespace = "DAV:")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class WebDavProperties {
    @XmlElement(name = "trashbin-original-filename", namespace = "http://owncloud.org/ns")
    private String trashbinOriginalFilename;

    @XmlElement(name = "trashbin-original-location", namespace = "http://owncloud.org/ns")
    private String trashbinOriginalLocation;

    @XmlElement(name = "trashbin-delete-datetime", namespace = "http://owncloud.org/ns", nillable = true)
    @XmlJavaTypeAdapter(JavaTimestampAdapter.class)
    private ZonedDateTime trashbinDeleteDatetime;

    @XmlElement(name = "getcontentlength", namespace = "DAV:", nillable = true)
    private Long contentLength = null;

    @XmlElement(name = "resourcetype", namespace = "DAV:")
    private ResourceType resourceType = null;
}
