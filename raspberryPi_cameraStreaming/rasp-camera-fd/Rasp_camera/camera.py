import cv2

haar_cascade = cv2.CascadeClassifier("haarcascade_frontalface_alt2.xml")

# scaling factor
# this should be adjusted
ds_factor = 0.6


class Camera(object):
    def __init__(self):
        self.video = cv2.VideoCapture(0)

    def __del__(self):
        self.video.release()

    def get_frame(self):
        stream, image = self.video.read()
        image = cv2.resize(
            image, None, fx=ds_factor, fy=ds_factor, interpolation=cv2.INTER_AREA
        )
        gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        rects = haar_cascade.detectMultiScale(gray, 1.3, 5)

        for (x, y, w, h) in rects:
            cv2.rectangle(image, (x, y), (x + w, y + h), (0, 255, 0), 2)
            break

        ret, jpeg = cv2.imencode(".jpg", image)

        return jpeg
