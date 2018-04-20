package net.bakaar.sandbox.cas.infra.event.db;

import net.bakaar.sandbox.event.common.DomainEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DBDomainEventEmitterTest {

    @Mock
    private EventRaisedRepository repository;
    @InjectMocks
    private DBDomainEventEmitter emitter;

    @Test
    public void emit_should_save_event_in_db() throws Exception {
        // Given
        DomainEvent event = mock(DomainEvent.class);
        // When
        emitter.emit(event);
        // Then
        ArgumentCaptor<EventRaised> captor = ArgumentCaptor.forClass(EventRaised.class);
        verify(repository).save(captor.capture());
        EventRaised eventRaised = captor.getValue();
        assertThat(eventRaised).isNotNull();
    }
}