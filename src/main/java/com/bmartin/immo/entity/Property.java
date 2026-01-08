package com.bmartin.immo.entity;

import com.bmartin.immo.entity.enums.PropertyType;
import com.bmartin.immo.entity.enums.PublicationStatus;
import com.bmartin.immo.entity.enums.SalesStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    ///////////////////
    // Entity fields //
    ///////////////////

    // Mandatory fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, name = "price_eur")
    private Integer priceEur;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "property_type", length = 30)
    private PropertyType propertyType; // HOUSE, APARTMENT

    @Column(nullable = false, name = "surface_m2", precision = 10, scale = 2)
    private BigDecimal surfaceM2;

    @Column(nullable = false)
    private Integer rooms;

    @Column(nullable = false, length = 120)
    private String city;

    @Column(nullable = false, length = 20, name = "postal_code")
    private String postalCode;

    // Status fields
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "publication_status", length = 30)
    private PublicationStatus publicationStatus; // DRAFT, PUBLISHED, ARCHIVED

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "sales_status", length = 30)
    private SalesStatus salesStatus; // AVAILABLE, UNDER_OFFER, SOLD

    // Optional fields
    private Integer bedrooms;

    @Column(precision = 10, scale = 2, name = "land_surface_m2")
    private BigDecimal landSurfaceM2;

    @Column(name = "energy_rating", length = 5)
    private String energyRating; // e.g., "A", "B", "C", etc.

    @Column (name = "energy_report_date")
    private LocalDate energyReportDate;

    private Integer yearBuilt;

    private Integer floor;

    @Column(nullable = false)
    private boolean hasElevator;

    @Column(nullable = false)
    private boolean hasBalcony;

    @Column(nullable = false)
    private boolean hasTerrace;

    @Column(nullable = false)
    private boolean hasGarden;

    @Column(length = 255)
    private String parking;

    @Column(length = 255)
    private String heating;

    // Timestamps for the creation and update of the property record
    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
}
