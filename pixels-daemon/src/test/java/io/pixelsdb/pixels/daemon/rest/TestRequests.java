/*
 * Copyright 2023 PixelsDB.
 *
 * This file is part of Pixels.
 *
 * Pixels is free software: you can redistribute it and/or modify
 * it under the terms of the Affero GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Pixels is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Affero GNU General Public License for more details.
 *
 * You should have received a copy of the Affero GNU General Public
 * License along with Pixels.  If not, see
 * <https://www.gnu.org/licenses/>.
 */
package io.pixelsdb.pixels.daemon.rest;

import com.alibaba.fastjson.JSON;
import io.pixelsdb.pixels.daemon.rest.request.OpenEngineConn;
import org.junit.Test;

import java.util.Properties;

/**
 * Created at: 3/17/23
 * Author: hank
 */
public class TestRequests
{
    @Test
    public void test()
    {
        Properties properties = new Properties();
        properties.setProperty("user", "pixels");
        OpenEngineConn openEngineConn = new OpenEngineConn("trino", properties, "", "jdbc:trino://");
        String json = JSON.toJSONString(openEngineConn);
        System.out.println(json);
        OpenEngineConn obj = JSON.parseObject(json, OpenEngineConn.class);
        assert obj.getProperties().getProperty("user").equals("pixels");
    }
}
