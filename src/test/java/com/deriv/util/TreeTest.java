package com.deriv.util;

import org.junit.jupiter.api.Test;

public class TreeTest {
  @Test
  void makeTest() {
    Tree<Integer> newTree = Tree.makeNode(1).add(Tree.makeNode(2).add(Tree.makeNode(17))).add(Tree.makeNode(5));
    System.out.println(newTree);
  }
}