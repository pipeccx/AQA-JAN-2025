package org.prog.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.dto.Location;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Name name;
    private Location location;
    private String gender;
}
