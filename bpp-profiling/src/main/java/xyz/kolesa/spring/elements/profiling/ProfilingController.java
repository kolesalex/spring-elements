package xyz.kolesa.spring.elements.profiling;

import lombok.Data;

@Data
public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled;
}
