package in.adarshsingh.gatekeeper.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "route_header_rules")
@Getter
@Setter
@NoArgsConstructor
public class RouteHeaderRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_pk", nullable = false)
    private ApiRoute route;

    private String direction;
    private String action;
    private String headerName;
    private String headerValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
