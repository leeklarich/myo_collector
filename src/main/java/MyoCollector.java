import com.thalmic.myo.*;

public class MyoCollector {
    public static void main(String[] args) {
        try {
            Hub hub = new Hub("com.myoemg.MyoCollector");
            Myo myo = hub.waitForMyo(10000);
            hub.addListener(new AbstractDeviceListener() {
                @Override
                public void onPair(Myo myo, long timestamp, FirmwareVersion firmwareVersion) {
                    super.onPair(myo, timestamp, firmwareVersion);
                    System.out.println("Myo connected!");
                }

                @Override
                public void onAccelerometerData(Myo myo, long timestamp, Vector3 accel) {
                    super.onAccelerometerData(myo, timestamp, accel);
                    System.out.println("Acc:\t" + accel.toString() + "\t" + accel.getX() + "\t" + accel.getY() + "\t" + accel.getZ());
                }

                @Override
                public void onGyroscopeData(Myo myo, long timestamp, Vector3 gyro) {
                    super.onGyroscopeData(myo, timestamp, gyro);
                    System.out.println("Gyro:\t" + gyro.toString() + "\t" + gyro.getX() + "\t" + gyro.getY() + "\t" + gyro.getZ());
                }
            });
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
