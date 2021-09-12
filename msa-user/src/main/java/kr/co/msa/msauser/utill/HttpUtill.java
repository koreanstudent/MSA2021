package kr.co.msa.msauser.utill;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpUtill {

    public static URI getCurrentUri(Long id) throws URISyntaxException{
        String path = (id == null) ? "" : "/" + id;
        String requestUri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        return new URI(requestUri.substring(requestUri.indexOf("/", 8)) + path);
    }
}
