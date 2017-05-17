/**
*
* Copyright (c) 2017 ytk-learn https://github.com/yuantiku
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.

* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

package com.fenbi.ytklearn.loss;

/**
 * @author xialong
 */

public class HuberFunction implements ILossFunction {
    private final double delta;
    public HuberFunction(double delta) {
        this.delta = delta;
    }
    @Override
    public double loss(double score, double label) {
        double absa = Math.abs(score - label);
        if (absa <= delta) {
            return 0.5 * absa * absa;
        } else {
            return delta * (absa - 0.5 * delta);
        }

    }

    @Override
    public double predict(double score) {
        return score;
    }

    @Override
    public double firstDerivative(double score, double label) {
        double a = score - label;
        if (Math.abs(a) <= delta) {
            return a;
        } else {
            return Math.signum(a) * delta;
        }
    }

    @Override
    public double secondDerivative(double score, double label) {
        return 0;
    }

    @Override
    public String getName() {
        return "huber";
    }
}