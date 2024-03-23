package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.CertificateEntity;
import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import com.byteacademy.byteacademy.dao.entity.EnrollmentEntity;
import com.byteacademy.byteacademy.model.certificate.request.RegisterCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.FullCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.MiniCertificateDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CertificateMapper {

    @Mapping(target = "enrollment", source = "enrollmentId", qualifiedByName = "toEnrollmentEntity")
    CertificateEntity mapToEntity(RegisterCertificateDTO registerCertificateDTO);

    FullCertificateDTO mapToFullDTO(CertificateEntity certificateEntity);
    MiniCertificateDTO mapToMiniDTO(CertificateEntity certificateEntity);
    CertificateEntity mapToUpdateEntity(@MappingTarget CertificateEntity certificateEntity, RegisterCertificateDTO certificateDTO);

    @Named("toEnrollmentEntity")
    default EnrollmentEntity toEnrollmentEntity(Long enrollmentId) {
        if (enrollmentId == null) {
            return null;
        }
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
        enrollmentEntity.setId(enrollmentId);
        return enrollmentEntity;
    }
}
