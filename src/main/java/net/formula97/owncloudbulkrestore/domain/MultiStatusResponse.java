package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@XmlRootElement(name = "multistatus", namespace = "http://sabredav.org/ns")
@XmlAccessorType(XmlAccessType.NONE)
public class MultiStatusResponse {

    @XmlElement(name = "response", namespace = "DAV:")
    private List<Response> response;

    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Response {
        @XmlElement(name = "href", namespace = "DAV:")
        private String href;

        @XmlElement(name = "propstat", namespace = "DAV:")
        private List<WebDavPropStat> propStat;
    }
}
