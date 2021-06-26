package net.formula97.owncloudbulkrestore.domain;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.NONE)
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ResourceType {

    @XmlElement(name = "collection", namespace = "DAV:")
    private Collection collection;

    @XmlAccessorType(XmlAccessType.NONE)
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class Collection {}
}
