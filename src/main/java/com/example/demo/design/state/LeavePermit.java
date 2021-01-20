package com.example.demo.design.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by @author ymtNSN on 2020/7/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeavePermit {

    private LeavePermitEnum leavePermitEnum;

    private Status status;

    private Event event;

    private String user;
}
