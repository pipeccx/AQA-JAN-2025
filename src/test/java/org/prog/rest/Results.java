package org.prog.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.dto.PersonDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private List<Result> results;
    }

