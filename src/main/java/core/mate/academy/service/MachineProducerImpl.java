package core.mate.academy.service;

import java.util.List;

public class MachineProducerImpl<T> implements MachineProducer {
    private final MachineProducer<T> producer; // Виробник машин

    public MachineProducerImpl(MachineProducer<T> producer) {
        this.producer = producer;
    }

    @Override
    public List<T> get() {
        return producer.get();
    }
}
