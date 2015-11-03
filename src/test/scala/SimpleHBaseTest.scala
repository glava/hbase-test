import org.apache.hadoop.hbase.HBaseTestingUtility
import org.apache.hadoop.hbase.client.Get
import org.apache.hadoop.hbase.util.Bytes
import org.scalatest.FunSpec
import HBaseService._

class SimpleHBaseTest extends FunSpec {
  val utility: HBaseTestingUtility = new HBaseTestingUtility
  utility.startMiniCluster()
  val table = utility.createTable(Bytes.toBytes("MyTest"), CF)

  describe("when executed") {
    it("it should not cry") {
      val model = new HBaseModel("DATA-1", "DATA-2", "ROWKEY-1")
      insertRecord(table, model)

      val get = new Get(Bytes.toBytes(model.rowKey))
      get.addColumn(CF, CQ1)

      val result = table.get(get)
      assert(Bytes.toString(result.getRow) == model.rowKey)
      assert(Bytes.toString(result.value) == model.data1)
    }
  }
}
