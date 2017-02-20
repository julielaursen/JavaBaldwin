//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;

class Proj03Runner {
    private Picture pic = new Picture("Proj03a.bmp");
    private double scale;
    private int yIntercept;
    private boolean scaleRightOfCubicLine;
    private Color cubicLineColor;
    private int cubicLineHalfWidth;

    Proj03Runner() {
        this.scale = (double)(-this.pic.getHeight()) / 2.2D;
        this.yIntercept = this.pic.getHeight() / 2;
        this.scaleRightOfCubicLine = false;
        this.cubicLineColor = Color.BLACK;
        this.cubicLineHalfWidth = 10;
        System.out.println("Julie Laursen.");
    }

    Picture getPicture() {
        return this.pic;
    }

    void run() {
        int totalHeight = this.pic.getHeight();
        int totalWidth = this.pic.getWidth();

        for(int col= 0; col < pic.getWidth(); ++col) {
            for(int row = 0; row < pic.getHeight(); ++row) {
                Pixel pixel = pic.getPixel(col, row);
                int redPixel = pixel.getRed();
                int greenPixel = pixel.getGreen();
                int bluePixel = pixel.getBlue();
                double var9 = 1.0D;
                double var11 = (double)col / (double)totalWidth;
                double var13 = (double)(totalWidth - col) / (double)totalWidth;
                double var15 = cubicFunction((double)(col - pic.getWidth() / 2) / (double)(pic.getWidth() / 2));
                double var17 = scale * var15 + (double)yIntercept;
                if((double)row < var17 + (double)cubicLineHalfWidth && (double)row > var17 - (double)cubicLineHalfWidth) {
                    pixel.setColor(cubicLineColor);
                } else if((double)row > var17 && scaleRightOfCubicLine) {
                    pixel.setRed((int)((double)redPixel * var9));
                    pixel.setGreen((int)((double)greenPixel * var11));
                    pixel.setBlue((int)((double)bluePixel * var13));
                } else if((double)row < var17 && !this.scaleRightOfCubicLine) {
                    pixel.setRed((int)((double)redPixel * var9));
                    pixel.setGreen((int)((double)greenPixel * var11));
                    pixel.setBlue((int)((double)bluePixel * var13));
                }
            }
        }

        this.pic.addMessage("I certify that this program is my own work", 10, 20);
        this.pic.addMessage("and is not the work of others. I agree not", 10, 38);
        this.pic.addMessage("to share my solution with others.", 10, 56);
        this.pic.addMessage("Julie Laursen.", 10, 74);
        this.pic.explore();
    }

    private double cubicFunction(double var1) {
        double var3 = var1 * var1 * var1;
        return var3;
    }
}
