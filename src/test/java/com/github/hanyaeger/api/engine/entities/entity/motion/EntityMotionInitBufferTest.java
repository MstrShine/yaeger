package com.github.hanyaeger.api.engine.entities.entity.motion;

import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EntityMotionInitBufferTest {

    public static final int SPEED = 4;
    public static final int DIRECTION = 37;
    private EntityMotionInitBuffer sut;
    private MotionApplier motionApplier;
    private Injector injector;

    @BeforeEach
    void setup() {
        sut = new EntityMotionInitBuffer();
        injector = mock(Injector.class);
        motionApplier = mock(MotionApplier.class);
        sut.setMotionApplier(motionApplier);
    }

    @Test
    void settingSpeedBeforeInitAndCallingInitSetsSpeedOnMotionApplier() {
        // Arrange
        sut.setSpeed(SPEED);

        // Act
        sut.init(injector);

        // Assert
        verify(motionApplier).setMotion(SPEED, 0d);
    }

    @Test
    void settingDirectionBeforeInitAndCallingInitSetsDirectionOnMotionApplier() {
        // Arrange
        sut.setDirection(DIRECTION);

        // Act
        sut.init(injector);

        // Assert
        verify(motionApplier).setMotion(0d, DIRECTION);
    }

    @Test
    void settingMotionBeforeInitAndCallingInitSetsMotionOnMotionApplier() {
        // Arrange
        sut.setMotion(SPEED, DIRECTION);

        // Act
        sut.init(injector);

        // Assert
        verify(motionApplier).setMotion(SPEED, DIRECTION);
    }
}
