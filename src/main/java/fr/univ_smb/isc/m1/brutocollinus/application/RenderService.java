package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.mediatype.hal.CurieProvider;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.stereotype.Service;

@Service
public class RenderService {
    private ObjectMapper objectMapper;

    public RenderService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new Jackson2HalModule());
        this.objectMapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(
                new EvoInflectorLinkRelationProvider(), CurieProvider.NONE, MessageResolver.DEFAULTS_ONLY));
    }


    public String render(Object model) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(model);
    }
}
