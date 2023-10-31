package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.EditorialDto;
import com.example.Apibiblioteca.mapper.MapperEditorial;
import com.example.Apibiblioteca.model.Editorial;
import com.example.Apibiblioteca.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements Editorialservicio{
private final EditorialRepository editorialRepository;
    @Override
    public List<EditorialDto> consultaEditorial() {
        List<EditorialDto>listaEditorial= editorialRepository.findAll().stream()
                .map(MapperEditorial::toDto)//mapea el objeto editorial al Dto
                .collect(Collectors.toList());//colecta los datos en una lista
        return listaEditorial;
    }

    @Override
    public String crearEditorial(EditorialDto editorialDto) {
        Editorial editorialEntity= MapperEditorial.toEntity(editorialDto);
        editorialRepository.save(editorialEntity);

        return "el editorial fue guardado con exito";

    }

    @Override
    public EditorialDto findEditorial(String nombre) {
        Editorial editorialEntity=  editorialRepository.findByNombre(nombre);
        EditorialDto editorialDto= MapperEditorial.toDto(editorialEntity);

        return editorialDto;

    }

    @Override
    public String modificarEditorial(Long id, EditorialDto editorialDto) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();

        editorial.setNombre(editorialDto.getNombre());
        editorial.setAlta(editorialDto.getAlta());

        editorialRepository.save(editorial);

        return "La editorial fue modificada con exito";
    }

    @Override
    public String bajaEditorial(Long id) {
        editorialRepository.deleteById(id);

        return "La editorial fue eliminada con exito";

    }
}
