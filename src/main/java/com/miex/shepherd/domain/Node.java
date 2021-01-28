package com.miex.shepherd.domain;

import lombok.Data;

@Data
public class Node {
    String host;
    String port;
    String nodeName;
    Integer nodeIndex;
    String password;
}
