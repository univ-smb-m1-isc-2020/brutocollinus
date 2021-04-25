package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedMatchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MatchRenderServiceTest {
    private MatchRenderService matchRenderService;
    private RenderedMatchRepository repository;

    @BeforeEach
    void setup() {
        this.repository = mock(RenderedMatchRepository.class);
        RenderService renderService = new RenderService();
        this.matchRenderService = new MatchRenderService(this.repository, renderService);
    }

    @Test
    void shouldDeleteAndSaveRenderForEveryMatch() {
        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("", brutoClass, null);
        ArmedBruto armedBruto = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        Entry entry = new Entry(armedBruto);
        Match match1 = new Match();
        match1.setChildren(entry, entry);
        Match match2 = new Match();
        match2.setChildren(entry, entry);

        this.matchRenderService.renderAll(List.of(match1, match2));
        ArgumentCaptor<Match> matchesCaptur = ArgumentCaptor.forClass(Match.class);
        verify(this.repository, times(2)).deleteByMatch(matchesCaptur.capture());

        assertEquals(matchesCaptur.getAllValues().get(0), match1);
        assertEquals(matchesCaptur.getAllValues().get(1), match2);

        ArgumentCaptor<RenderedMatch> renderedMatchesCaptur = ArgumentCaptor.forClass(RenderedMatch.class);
        verify(this.repository, times(2)).save(renderedMatchesCaptur.capture());

        for (int i = 0; i < 2; ++i) {
            RenderedMatch renderedMatch = renderedMatchesCaptur.getAllValues().get(i);
            Match match = matchesCaptur.getAllValues().get(i);
            assertEquals(match, renderedMatch.match());
            assertTrue(renderedMatch.content().length() > 0);
        }
    }
}
