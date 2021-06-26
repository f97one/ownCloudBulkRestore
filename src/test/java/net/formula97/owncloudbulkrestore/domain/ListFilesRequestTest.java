package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.JAXB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ListFilesRequestTest {

    @Test
    @DisplayName("リクエストボディをマーシャルできる")
    void canMarshalRequest() {
        // https://doc.owncloud.com/server/developer_manual/webdav_api/trashbin.html#list-files の例とは異なるが、
        // これでちゃんと受け付けられる
        String bodyStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<d:propfind xmlns:oc=\"http://owncloud.org/ns\" xmlns:d=\"DAV:\">\n" +
                "    <d:prop>\n" +
                "        <oc:trashbin-original-filename></oc:trashbin-original-filename>\n" +
                "        <oc:trashbin-original-location></oc:trashbin-original-location>\n" +
                "        <oc:trashbin-delete-datetime xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <d:getcontentlength xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <d:resourcetype/>\n" +
                "    </d:prop>\n" +
                "</d:propfind>\n";

        ListFilesRequest req = JAXB.unmarshal(new StringReader(bodyStr), ListFilesRequest.class);

        StringWriter sw = new StringWriter();
        JAXB.marshal(req, sw);

        assertEquals(bodyStr, sw.toString());
    }
}