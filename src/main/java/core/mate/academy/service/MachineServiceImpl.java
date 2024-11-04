package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends T> type) {
        // Використання умов для вибору відповідного виробника машин на основі типу
        if (type == Bulldozer.class) {
            MachineProducer<Bulldozer> bulldozerProducer = new BulldozerProducer();
            return (List<T>) bulldozerProducer.get();
        } else if (type == Excavator.class) {
            MachineProducer<Excavator> excavatorProducer = new ExcavatorProducer();
            return (List<T>) excavatorProducer.get();
        } else if (type == Truck.class) {
            MachineProducer<Truck> truckProducer = new TruckProducer();
            return (List<T>) truckProducer.get();
        }

        // Повертаємо пустий список, якщо тип не співпадає
        return List.of();
    }

    @Override
    public void fill(List<? super T> machines, Object value) {
        if (value instanceof Machine) {
            for (int i = 0; i < machines.size(); i++) {
                machines.set(i, (T) value);
            }
        } else {
            throw new IllegalArgumentException("Value is not a valid machine type.");
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }
}
