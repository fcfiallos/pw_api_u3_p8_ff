package uce.edu.web.api.service.mapper;

import java.util.List;

import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.service.to.HijoTo;

public class HijoMapper {
    public static HijoTo toTO(Hijo hijo) {
        HijoTo hijoTo = new HijoTo();
        hijoTo.setId(hijo.getId());
        hijoTo.setNombre(hijo.getNombre());
        hijoTo.setApellido(hijo.getApellido());
        return hijoTo;
    }

    public static List<HijoTo> toTOList(List<Hijo> hijo){
       return hijo.stream()
                .map(HijoMapper::toTO)
                .toList();
    }
}
