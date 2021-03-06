package com.bytezone.dm3270.display;

import com.bytezone.dm3270.attributes.ColorAttribute;
import java.awt.Color;

public class ScreenContext {

  public static final ScreenContext DEFAULT_CONTEXT = new ScreenContext(ColorAttribute.COLORS[0],
      ColorAttribute.COLORS[8], (byte) 0, false, false);

  public final Color foregroundColor;
  public final Color backgroundColor;
  public final byte highlight;
  public final boolean highIntensity;
  public final boolean isGraphic;

  public ScreenContext(Color foregroundColor, Color backgroundColor, byte highlight,
      boolean highIntensity, boolean isGraphic) {
    this.foregroundColor = foregroundColor;
    this.backgroundColor = backgroundColor;
    this.highlight = highlight;
    this.highIntensity = highIntensity;
    this.isGraphic = isGraphic;
  }

  public ScreenContext withBackgroundColor(Color color) {
    return new ScreenContext(foregroundColor, color, highlight, highIntensity, isGraphic);
  }

  public ScreenContext withHighlight(byte highlight) {
    return new ScreenContext(foregroundColor, backgroundColor, highlight, highIntensity,
        isGraphic);
  }

  public ScreenContext withForeground(Color color) {
    return new ScreenContext(color, backgroundColor, highlight, highIntensity, isGraphic);
  }

  public ScreenContext withGraphic(boolean isGraphic) {
    return new ScreenContext(foregroundColor, backgroundColor, highlight, highIntensity,
        isGraphic);
  }

  @Override
  public String toString() {
    return String.format("[Fg:%-10s Bg:%-10s In:%s  Hl:%02X]",
        ColorAttribute.getName(foregroundColor),
        ColorAttribute.getName(backgroundColor),
        (highIntensity ? 'x' : ' '), highlight);
  }

  public boolean isGraphic() {
    return isGraphic;
  }
}
