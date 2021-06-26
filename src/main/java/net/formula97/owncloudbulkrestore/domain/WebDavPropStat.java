package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@XmlRootElement(name = "propstat", namespace = "DAV:")
@XmlAccessorType(XmlAccessType.NONE)
public class WebDavPropStat {
    @XmlElement(name = "prop", namespace = "DAV:")
    private WebDavProperties prop;

    @XmlElement(name = "status")
    private String status;
}
