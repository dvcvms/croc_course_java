package ru.croc.task6;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {

        Annotation annotation = null;

        for (Annotation obj : annotations) {
            if (obj.comparePoints(x, y)) {
                annotation = obj;
                break;
            }
        }

        return annotation;
    }

    public Annotation findByLabel(String label) {

        Annotation annotation = null;

        for (Annotation obj : annotations) {
            if (obj.getLabel().contains(label)) {
                annotation = obj;
                break;
            }
        }

        return annotation;
    }
}
