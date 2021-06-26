package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlRootElement(name = "propfind", namespace = "DAV:")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
public class ListFilesRequest {
    @XmlElement(name = "prop", namespace = "DAV:")
    private WebDavProperties prop;
}
