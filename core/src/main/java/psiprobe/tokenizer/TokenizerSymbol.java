/*
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */

package psiprobe.tokenizer;

/**
 * The Class TokenizerSymbol.
 *
 * @author Vlad Ilyushchenko
 */
public class TokenizerSymbol implements Comparable<Object> {

  /** The name. */
  final String name;

  /** The start text. */
  final String startText;

  /** The tail text. */
  final String tailText;

  /** The hidden. */
  final boolean hidden;

  /** The decode paired. */
  final boolean decodePaired;

  /** The enabled. */
  final boolean enabled;

  /** The can be nested. */
  final boolean canBeNested;

  /**
   * Instantiates a new tokenizer symbol.
   *
   * @param name the name
   * @param startText the start text
   * @param tailText the tail text
   * @param hidden the hidden
   * @param decodePaired the decode paired
   * @param enabled the enabled
   * @param canBeNested the can be nested
   */
  public TokenizerSymbol(String name, String startText, String tailText, boolean hidden,
      boolean decodePaired, boolean enabled, boolean canBeNested) {

    this.name = name;
    this.startText = startText;
    this.tailText = tailText;
    this.hidden = hidden;
    this.decodePaired = decodePaired;
    this.enabled = enabled;
    this.canBeNested = canBeNested;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj instanceof Character) {
      return compareTo((Character) obj);
    }
    return compareTo((TokenizerSymbol) obj);
  }

  /**
   * Compare to.
   *
   * @param chr the chr
   * @return the int
   */
  public int compareTo(Character chr) {
    return chr - startText.charAt(0);
  }

  /**
   * Compare to.
   *
   * @param symbol the symbol
   * @return the int
   */
  public int compareTo(TokenizerSymbol symbol) {
    return symbol.startText.compareTo(startText);
  }

}
