# Android-and-RaspberryPi-Projects
アンドロイドアプリとラズベリーパイを用いたアプリケーション
各ディレクトリの概要は次の通り。

## measureApp
物体の幅を計測するアンドロイドアプリ(仮名：Mensura)
ディレクトリ Mensura はAndroidStudioのファイル群。（主なソースコードは、Mensura/app/src/mainの中）
簡単な概要を示したスライドはpptx、より詳細なレポートはpdfファイルをご参照ください。

## raspberryPi_cameraStreaming
ラズベリーパイに接続したカメラからの映像をアンドロイドアプリにストリーミングするIoTシステム
概要説明スライド：https://docs.google.com/presentation/d/1DdKIIuGqu1L7Pvuq8bTbUW6MkDh7z9UjzjZXvQVp80c/edit?usp=sharing

  #### RaspCamera
  AndroidStudioのファイル群。映像を受け取るアンドロイドアプリケーション側の実装。
  （主なソースコードは、raspberryPi_cameraStreaming/RaspCamera/app/src/の中）
  
  #### rasp-camera-fd
  RaspberryPiのLinux（サーバー側）での実装。(Python)
