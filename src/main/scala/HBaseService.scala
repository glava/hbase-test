import org.apache.hadoop.hbase.client.{HTable, Put}
import org.apache.hadoop.hbase.util.Bytes

object HBaseService {

  val CF: Array[Byte] = "CF".getBytes
  val CQ1: Array[Byte] = "CQ-1".getBytes
  val CQ2: Array[Byte] = "CQ-2".getBytes

  def insertRecord(table: HTable, obj: HBaseModel) {
    val put: Put = createPut(obj)
    table.put(put)
  }

  def createPut(obj: HBaseModel): Put = {
    val put: Put = new Put(Bytes.toBytes(obj.rowKey))
    put.add(CF, CQ1, Bytes.toBytes(obj.data1))
    put.add(CF, CQ2, Bytes.toBytes(obj.data2))
    return put
  }
}

case class HBaseModel(data1: String, data2: String, rowKey: String)
