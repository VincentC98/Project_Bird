package colval.qc.ca.bird_project.service.mapper;

public interface EntityMapper<T, D> {
    D entityToDto(T t);
    T DtoToEntity(D d);
}
