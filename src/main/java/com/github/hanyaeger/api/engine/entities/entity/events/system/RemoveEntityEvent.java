package com.github.hanyaeger.api.engine.entities.entity.events.system;

import com.github.hanyaeger.api.engine.entities.entity.Removable;
import com.github.hanyaeger.api.engine.entities.entity.events.EventTypes;
import javafx.event.Event;

/**
 * Send a {@code RemoveEntityEvent} when a  {@link Removable} needs to be removed.
 */
public class RemoveEntityEvent extends Event {

    private final transient Removable removable;

    /**
     * Instantiate a new {@code RemoveEntityEvent}. Pass the {@link Removable} as an argument.
     *
     * @param removable the {@link Removable} that needs to be removed
     */
    public RemoveEntityEvent(final Removable removable) {
        super(EventTypes.REMOVE);

        this.removable = removable;
    }

    @Override
    public Removable getSource() {
        return removable;
    }
}
