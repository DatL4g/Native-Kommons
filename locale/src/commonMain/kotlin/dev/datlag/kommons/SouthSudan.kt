package dev.datlag.kommons


data object SouthSudan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SS")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SSD")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(728)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(211)
}