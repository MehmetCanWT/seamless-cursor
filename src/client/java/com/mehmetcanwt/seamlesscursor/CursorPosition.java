package com.mehmetcanwt.seamlesscursor;

/**
 * Last ungrabbed (GUI) cursor position in window pixel coordinates.
 */
public final class CursorPosition {
	private static boolean saved;
	private static double x;
	private static double y;

	private CursorPosition() {
	}

	public static void save(double xpos, double ypos) {
		x = xpos;
		y = ypos;
		saved = true;
	}

	public static boolean has() {
		return saved;
	}

	public static double restoreX(double fallback, int width) {
		if (!saved) {
			return fallback;
		}
		return clamp(x, width);
	}

	public static double restoreY(double fallback, int height) {
		if (!saved) {
			return fallback;
		}
		return clamp(y, height);
	}

	private static double clamp(double value, int size) {
		if (size <= 1) {
			return 0.0;
		}
		return Math.clamp(value, 0.0, (double) (size - 1));
	}
}
